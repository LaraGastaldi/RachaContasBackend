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

        Schema::table('debts', function (Blueprint $table) use ($driver) {
            $table->text('description')->nullable()->change();

            if ($driver == 'sqlite') {
                $table->timestampTz('debt_date')->default(0)->change();
            } else {
                $table->timestampTz('debt_date')->change();
            }
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
    }
};
