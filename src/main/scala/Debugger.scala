object Debugger {
    def viewer(message: String, debugType: String) : Unit = {
        val color = debugType match {
            case "info" => Console.BLUE
            case "warning" => Console.YELLOW
            case "error" => Console.RED
            case "success" => Console.GREEN
            case _ => Console.WHITE
        }

        println(color + "\n" + message)
        Thread.sleep(2000)

        if (debugType == "error") {
            System.exit(0)
        }
    }
}