object Message {
    sealed trait MessageType

    case class Info() extends MessageType
    case class Warning() extends MessageType
    case class Error() extends MessageType
    case class Success() extends MessageType
    case class Other() extends MessageType

    def viewMessage(message: String, debugType: MessageType, delay:Int=0) : Unit = {
        val color = debugType match {
            case Info() => Console.BLUE
            case Warning() => Console.YELLOW
            case Error() => Console.RED
            case Success() => Console.GREEN
            case _ => Console.WHITE
        }

        println(color + "\n" + message)

        if (delay != 0) {
            Thread.sleep(delay*1000)
        }

        if (debugType == Error()) {
            System.exit(0)
        }
    }
}