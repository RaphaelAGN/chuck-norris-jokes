package com.RaphaelAGN.chucknorrisapp.endpoint

import com.RaphaelAGN.chucknorrisapp.models.JokeModel
import io.kotest.matchers.shouldBe
import org.junit.Test

class JokeMapperTest {

    @Test
    fun `WHEN JokeMapper to domain called THEN the return is a joke value` (){
        //WHEN
        val joke = JokeMapper.toDomain(jokeModel = JokeModel(listOf(), "", "", "", "joke", "", ""))

        //THEN
        joke.value shouldBe "joke"
    }
}