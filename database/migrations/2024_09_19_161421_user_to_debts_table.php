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

        Schema::create('user_to_debt', function (Blueprint $table) use ($driver) {
            $table->id();
            $table->timestamps();

            if ($driver == 'sqlite') {
                $table->string('name')->default('');
                $table->string('relationship')->default('');
                $table->string('phone')->nullable();
                $table->string('email')->default('');
                $table->timestamp('email_sent_at')->default(0);
                $table->timestamp('sms_sent_at')->default(0);
                $table->timestamp('verified_at')->default(0);
                $table->float('value', 2)->nullable();
            } else {
                $table->string('name');
                $table->string('relationship');
                $table->string('phone')->nullable();
                $table->string('email')->nullable();
                $table->timestamp('email_sent_at')->nullable();
                $table->timestamp('sms_sent_at')->nullable();
                $table->timestamp('verified_at')->nullable();
                $table->float('value', 2)->nullable();
            }
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('user_to_debt');
    }
};
