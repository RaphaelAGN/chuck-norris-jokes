package com.RaphaelAGN.chucknorrisapp.fragments

import android.os.Bundle
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.idling.CountingIdlingResource
import com.RaphaelAGN.chucknorrisapp.InstrumentedTestCoroutineContextProvider
import com.RaphaelAGN.chucknorrisapp.R
import com.RaphaelAGN.chucknorrisapp.core.CoroutineContextProvider
import com.RaphaelAGN.chucknorrisapp.domain.models.Joke
import com.RaphaelAGN.chucknorrisapp.repository.ChuckNorrisJokeRepository
import com.RaphaelAGN.chucknorrisapp.repository.ChuckNorrisJokeRepositoryImpl
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.dsl.module

@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    private val jokeRepository: ChuckNorrisJokeRepositoryImpl = mockk(relaxed = true)
    var idlingResource: CountingIdlingResource? = null

    fun getModule() = module(override = true) {
        single<CoroutineContextProvider> { InstrumentedTestCoroutineContextProvider() }
        factory<ChuckNorrisJokeRepository> { jokeRepository }
    }

    inline fun <reified F : Fragment> launchFragment(
        fragmentArgs: Bundle? = null,
        @StyleRes themeResId: Int = R.style.Theme_ChuckNorrisApp,
        factory: FragmentFactory? = null,
        crossinline action: ((fragment: FragmentScenario<F>) -> Unit) = { }
    ) = FragmentScenario.launchInContainer(F::class.java, fragmentArgs, themeResId, factory).apply {
        action(this)
    }

    fun launchFragment() {
        launchFragment<MainFragment> {
            it.onFragment {
                idlingResource = it.getIdlingResource()
                IdlingRegistry.getInstance().register(idlingResource)
            }
        }
    }

    @Before
    fun setup() {
        loadKoinModules(getModule())
        coEvery { jokeRepository.getApiJoke() } returns Joke("Joke")
    }

    @After
    fun clear() {
        unloadKoinModules(getModule())
    }

    @Test
    fun testeDeInterface() {
        //GIVEN
        launchFragment()
        val joke = Joke("Joke")

        //WHEN
        onView(withId(R.id.joke_button))
            .perform(click())

        //THEN
        onView(withId(R.id.joke_text_view))
            .check(matches(withText(joke.value)))
    }
}