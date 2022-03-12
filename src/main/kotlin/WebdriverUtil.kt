import org.openqa.selenium.WebElement
import java.math.BigDecimal

object WebdriverUtil {

    private val priceRegex = Regex("(\\d+[,.]\\d+)")

    fun parsePrice(ele: WebElement): BigDecimal {
        val text = ele.text
        val result = priceRegex.find(text)?.value?.replace(",", ".")

        return try {
            BigDecimal(result)
        } catch (e: java.lang.NumberFormatException) {
            println("Could not parse price of element with text '$text'")
            BigDecimal.ZERO
        }
    }
}