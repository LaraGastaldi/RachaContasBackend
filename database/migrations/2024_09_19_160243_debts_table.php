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

        Schema::create('debts', function (Blueprint $table) use ($driver) {
            $table->id();
            if ($driver == 'sqlite') {
                $table->string('name')->default('');
                $table->text('description')->default('');
                $table->float('total_value', 2)->default(0);
                $table->dateTime('debt_date')->default(0);
                $table->dateTime('max_pay_date')->nullable();
            } else {
                $table->string('name');
                $table->text('description');
                $table->float('total_value', 2);
                $table->dateTime('debt_date');
                $table->dateTime('max_pay_date')->nullable();
            }
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('debts');
    }
};
