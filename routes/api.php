<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::middleware(\App\Domain\Middlewares\SemiAuthMiddleware::class)->group(function () {
    require(base_path() . '/routes/Auth/auth.php');
    require(base_path() . '/routes/Debt/debt.php');
    require(base_path() . '/routes/UserToDebt/user_to_debt.php');
});

require(base_path() . '/routes/Other/open-routes.php');