package websites

import Website
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class Amazon(override val driver: ChromeDriver) : Website {

    override val urls =
        listOf(
            "https://www.amazon.de/Sony-Interactive-Entertainment-PlayStation-5/dp/B08H93ZRK9/ref=sr_1_1?keywords=playstation+5&qid=1647001864&sprefix=play%2Caps%2C91&sr=8-1",
            "https://www.amazon.de/Sony-PlayStation-Horizon-Forbidden-West/dp/B09QG2JZYS?__mk_de_DE=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2H9I9NL62GRIW&keywords=playstation+5&qid=1642403059&sprefix=playstation+5,aps,89&sr=8-6&linkCode=sl1&tag=gameswirtschaft-21&linkId=c0976b35da61c1de33792f2dd5043564&language=de_DE&ref_=as_li_ss_tl",
            "https://www.amazon.de/Sony-PlayStation-5-Digital-Edition/dp/B08H98GVK8?brr=1&pd_rd_r=4455c1f1-2042-49ca-8bf9-4c0f8d2ae13a&pd_rd_w=i49Tv&pd_rd_wg=Zby6e&qid=1641919603&rd=1&refinements=p_89:Playstation&rnid=669059031&s=videogames&sr=1-2&linkCode=sl1&tag=gameswirtschaft-21&linkId=6f756e6feff34b5b248700b884be7081&language=de_DE&ref_=as_li_ss_tl"
        )

    override fun checkAvailability() {
        val ele = driver.findElement(By.id("availability"))
        if (ele.text.contains("Auf Lager")) {
            handleSuccess("Playstation")
        }
    }

}
