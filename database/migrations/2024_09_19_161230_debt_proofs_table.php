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

        Schema::create('debt_proofs', function (Blueprint $table) use ($driver) {
            $table->id();
            $table->timestamps();
            if ($driver == 'sqlite') {
                $table->longText('src')->default('');
                $table->string('type')->default('');
    
                $table->bigInteger('debt_id')->unsigned()->default(0);
                $table->foreign('debt_id')->references('id')->on('debts');
    
                $table->bigInteger('user_id')->unsigned()->default(0);
                $table->foreign('user_id')->references('id')->on('users');
            } else {
                $table->longText('src');
                $table->string('type');
    
                $table->bigInteger('debt_id')->unsigned();
                $table->foreign('debt_id')->references('id')->on('debts');
    
                $table->bigInteger('user_id')->unsigned();
                $table->foreign('user_id')->references('id')->on('users');
            }

        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('debt_proofs');
    }
};
