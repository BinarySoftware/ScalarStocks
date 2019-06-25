import PublicDef._

object LaunchScreen {
    def makeLaunchScreen() : Unit = {
        clear()

        for (i <- 1 to 8) {
            println()
        }
        println(Console.GREEN + "".formatted(s"%-34s") + "ScalarStocks".formatted(s"%-34s"))
        for (i <- 1 to 3) {
            println()
        }
        println(Console.WHITE + "".formatted(s"%-29s") + "2019 Maciej Mikolajek".formatted(s"%-30s"))
        println("".formatted(s"%-37s") + "V 1.0".formatted(s"%-38s"))
    }
}