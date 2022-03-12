import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.AfterClass
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import websites.*
import java.time.Duration
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit

class ProductAvailableCheck {

    private lateinit var driver: ChromeDriver
    private lateinit var wait: WebDriverWait
    private lateinit var websites: List<Website>

    private val timeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")

    @BeforeClass
    fun createDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\svenw\\Downloads\\chromedriver.exe")
        driver = ChromeDriver()
        wait = WebDriverWait(driver, Duration.ofSeconds(5))
        PageFactory.initElements(driver, this)

        websites = listOf(
            Amazon(driver), MediaMarkt(driver), Otto(driver),
            Alternate(driver), Expert(driver), Mueller(driver),
            Euronics(driver)
        )
    }

    @Test
    fun main() {
        var counter = 1
        while (true) {
            println("Run $counter\t" + LocalTime.now().format(timeFormatter))

            websites.forEach { it.verifyUrls() }

            TimeUnit.MINUTES.sleep(3L)
            counter++
        }
    }

    @AfterClass(alwaysRun = true)
    @AfterSuite(alwaysRun = true)
    fun teardown() {
        driver.quit()
    }
}