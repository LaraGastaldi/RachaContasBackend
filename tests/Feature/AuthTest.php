<?php

namespace Tests\Feature;
use Tests\TestCase;

class AuthTest extends TestCase
{
    public function setUp(): void
    {
        parent::setUp();
    }

    public function test_register()
    {
        $response = $this->post('/register', [
            'first_name' => 'test',
            'last_name' => 'test',
            'email' => 'test@gmail.com',
            'password'=> '12345',
        ], $this->header);

        $response->assertStatus(201);
        $this->assertDatabaseHas('users', [
            'first_name'=> 'test',
        ]);
    }

    public function test_login()
    {
        $response = $this->post('/login', [
            'email' => $this->user->email,
            'password'=> '12345',
        ], $this->header);

        $response->assertStatus(200);
    }
}