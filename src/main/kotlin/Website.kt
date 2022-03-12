import org.openqa.selenium.chrome.ChromeDriver
import java.awt.Toolkit
import java.net.URI
import java.util.concurrent.TimeUnit

interface Website {

    val urls: List<String>
    val driver: ChromeDriver


    fun checkAvailability()

    private fun open(url: String) {
        driver.get(url)
        println("Website '${URI(url).host}' opened")
    }

    fun verifyUrls() {
        urls.forEach {
            open(it)
            checkAvailability()
        }
    }

    fun handleSuccess(product: String) {
        println("SUCCESS: Product $product is available on ${URI(driver.currentUrl).host}.")
        val sound = Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation") as Runnable
        while (true) {
            sound.run()
            TimeUnit.SECONDS.sleep(2)
        }
    }
}