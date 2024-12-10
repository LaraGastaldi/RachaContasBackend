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

        Schema::create('jobs', function (Blueprint $table) use ($driver) {
            if ($driver == 'sqlite') {
                $table->id();
                $table->string('queue')->index()->default('');
                $table->longText('payload')->default('');
                $table->unsignedTinyInteger('attempts')->default(0);
                $table->unsignedInteger('reserved_at')->nullable();
                $table->unsignedInteger('available_at')->default(0);
                $table->unsignedInteger('created_at')->default(0);
            } else {
                $table->id();
                $table->string('queue')->index();
                $table->longText('payload');
                $table->unsignedTinyInteger('attempts');
                $table->unsignedInteger('reserved_at')->nullable();
                $table->unsignedInteger('available_at');
                $table->unsignedInteger('created_at');
            }
        });

        Schema::create('job_batches', function (Blueprint $table) use ($driver) {
            if ($driver == 'sqlite') {
                $table->string('id')->primary()->default('');
                $table->string('name')->default('');
                $table->integer('total_jobs')->default(0);
                $table->integer('pending_jobs')->default(0);
                $table->integer('failed_jobs')->default(0);
                $table->longText('failed_job_ids')->default('');
                $table->mediumText('options')->default('');
                $table->integer('cancelled_at')->nullable();
                $table->integer('created_at')->default(0);
                $table->integer('finished_at')->nullable();
            } else {
                $table->string('id')->primary();
                $table->string('name');
                $table->integer('total_jobs');
                $table->integer('pending_jobs');
                $table->integer('failed_jobs');
                $table->longText('failed_job_ids');
                $table->mediumText('options')->nullable();
                $table->integer('cancelled_at')->nullable();
                $table->integer('created_at');
                $table->integer('finished_at')->nullable();
            }
        });

        Schema::create('failed_jobs', function (Blueprint $table) use ($driver) {
            if ($driver == 'sqlite') {
                $table->id();
                $table->string('uuid')->default('');
                $table->text('connection')->default('');
                $table->text('queue')->default('');
                $table->longText('payload')->default('');
                $table->longText('exception')->default('');
                $table->timestamp('failed_at')->useCurrent();
            } else {
                $table->id();
                $table->string('uuid')->unique();
                $table->text('connection');
                $table->text('queue');
                $table->longText('payload');
                $table->longText('exception');
                $table->timestamp('failed_at')->useCurrent();
            }
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('jobs');
        Schema::dropIfExists('job_batches');
        Schema::dropIfExists('failed_jobs');
    }
};
