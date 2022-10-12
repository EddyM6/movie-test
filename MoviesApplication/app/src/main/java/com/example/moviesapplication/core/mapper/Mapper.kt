package com.example.moviesapplication.core.mapper

interface Mapper<InputType, OutputType> {
    fun map(inputModel: InputType): OutputType
}