package com.example.itc362_hw6_ex1b

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {

    private lateinit var scenario: FragmentScenario<CrimeDetailFragment>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer()
    }

    @After
    fun tearDown() {
        if (::scenario.isInitialized) {
            scenario.close()
        }
    }

    @Test
    fun confirmCheckBox() {
        onView(withId(R.id.crime_solved))
            .check(matches(isDisplayed()))
    }

    @Test
    fun confirmEditText() {
        onView(withId(R.id.crime_title))
            .check(matches(isDisplayed()))
    }

    @Test
    fun updateCrime() {
        scenario.onFragment { fragment ->
            // Update the Crime object
            fragment.crime.title = "Burglary"
            fragment.crime.isSolved = true

            // Verify the updates
            assertEquals("Burglary", fragment.crime.title)
            assertTrue(fragment.crime.isSolved)
        }
    }
}
