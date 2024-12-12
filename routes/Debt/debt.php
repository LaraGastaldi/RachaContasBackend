<?php
use App\Domain\Controllers\DebtController;
use App\Domain\Models\Debt;
use App\Domain\Models\User;
use Illuminate\Support\Facades\Route;

Route::middleware(
    'auth'
)->group(function () {
    Route::get('/debt', [DebtController::class, 'getAllByUser']); 
    Route::get('/debt/{id}', [DebtController::class, 'find']);
    Route::post('/debt', [DebtController::class, 'create']);
    Route::patch('/debt/{id}', [DebtController::class, 'update']);
    Route::delete('/debt/{id}', [DebtController::class, 'delete']);
    Route::post('/debt/{id}/total-pay', [DebtController::class, 'totalPay']);
    Route::post('/debt/partial-pay', [DebtController::class,'partialPay']);
});