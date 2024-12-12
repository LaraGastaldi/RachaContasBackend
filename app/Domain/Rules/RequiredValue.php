<?php

namespace App\Domain\Rules;

use Illuminate\Contracts\Validation\Rule;

class RequiredValue implements Rule
{
    protected $array;
    protected $relationship;

    /**
     * Create a new rule instance.
     *
     * @param  array  $array
     * @param  string  $relationship
     * @return void
     */
    public function __construct(array $array, $relationship)
    {
        $this->array = $array;
        $this->relationship = $relationship;
    }

    /**
     * Determine if the validation rule passes.
     *
     * @param  string  $attribute
     * @param  mixed  $value
     * @return bool
     */
    public function passes($attribute, $value)
    {
        if (count($this->array) > 1 && $this->relationship == 'payer' && empty($value)) {
            return false;
        }

        return true;
    }

    /**
     * Get the validation error message.
     *
     * @return string
     */
    public function message()
    {
        return __('validation.required');
    }
}
