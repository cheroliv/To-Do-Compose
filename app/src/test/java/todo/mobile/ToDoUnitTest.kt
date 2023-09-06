package todo.mobile


import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.KoinTest
import org.koin.test.verify.verify
import kotlin.test.Test
import kotlin.test.assertEquals

class ToDoUnitTest : KoinTest {

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkAllModules() = Modules.appModule.verify()


    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}