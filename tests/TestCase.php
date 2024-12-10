<?php

namespace Tests;

use App\Domain\Models\User;
use Illuminate\Foundation\Testing\DatabaseMigrations;
use Illuminate\Foundation\Testing\DatabaseTransactions;
use Illuminate\Foundation\Testing\TestCase as BaseTestCase;

abstract class TestCase extends BaseTestCase
{
    protected $user;
    protected $header;

    use DatabaseMigrations;
    public function setUp(): void
    {
        parent::setUp();
        $this->user = new User([
            "email" => fake('pt_BR')->email,
            'password'=> '12345',
            "first_name" => fake("pt_BR")->name(),
            "last_name"=> fake("pt_BR")->lastName(),
        ]);
        $this->user->save();

        $this->header = [
            'Authorization2' => env('API_SECRET')
        ];
    }
}
