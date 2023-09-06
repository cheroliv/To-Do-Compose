package todo.mobile

import org.junit.Assert
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.KoinTest
import org.koin.test.verify.verify

class ToDoUnitTest : KoinTest {

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkAllModules() = Modules.appModule.verify()


    @Test
    fun addition_isCorrect() {
        Assert.assertEquals(4, 2 + 2)
    }
}