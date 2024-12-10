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

        Schema::table('user_to_debt', function (Blueprint $table) use ($driver) {
            if ($driver == 'sqlite') {
                $table->bigInteger('user_id')->unsigned()->default(0);
                $table->foreign('user_id')->references('id')->on('users');

                $table->bigInteger('debt_id')->unsigned()->default(0);
                $table->foreign('debt_id')->references('id')->on('debts');
            } else {
                $table->bigInteger('user_id')->unsigned();
                $table->foreign('user_id')->references('id')->on('users');

                $table->bigInteger('debt_id')->unsigned();
                $table->foreign('debt_id')->references('id')->on('debts');
            }
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('user_to_debt', function (Blueprint $table) {
            $table->dropForeign(['user_id']);
            $table->dropColumn('user_id');

            $table->dropForeign(['debt_id']);
            $table->dropColumn('debt_id');
        });
    }
};
