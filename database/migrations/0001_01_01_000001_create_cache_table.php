<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        $driver = Schema::connection($this->getConnection())->getConnection()->getDriverName();

        Schema::create('cache', function (Blueprint $table) use ($driver) {
            if ($driver == 'sqlite') {
                $table->string('key')->primary()->default('');
                $table->mediumText('value')->default('');
                $table->integer('expiration')->default(0);
            } else {
                $table->string('key')->primary();
                $table->mediumText('value');
                $table->integer('expiration');
            }
        });

        Schema::create('cache_locks', function (Blueprint $table) use ($driver) {
            if ($driver == 'sqlite') {
                $table->string('key')->primary()->default('');
                $table->string('owner')->default('');
                $table->integer('expiration')->default(0);
            } else {
                $table->string('key')->primary();
                $table->string('owner');
                $table->integer('expiration');
            }
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('cache');
        Schema::dropIfExists('cache_locks');
    }
};
