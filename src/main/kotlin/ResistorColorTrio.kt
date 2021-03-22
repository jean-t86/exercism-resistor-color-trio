object ResistorColorTrio {

    fun text(vararg input: Color): String {
        val strBuilder = StringBuilder()

        input
            .take(2)
            .forEach { color ->
                strBuilder.append(color.ordinal)
            }

        repeat(input.last().ordinal) {
            strBuilder.append("0")
        }

        val ohms = strBuilder.toString().toLong()
        val unit: String
        val ohmsWithUnit: Double
        ohmsWithUnit = when (ohms) {
            in Unit.OHMS.multiplier..Unit.KILOOHMS.multiplier -> {
                unit = "ohms"
                ohms * 1.0
            }
            in Unit.KILOOHMS.multiplier..Unit.MEGAOHMS.multiplier -> {
                unit = "kiloohms"
                ohms / Unit.KILOOHMS.multiplier * 1.0
            }
            in Unit.MEGAOHMS.multiplier..Unit.GIGAOHMS.multiplier -> {
                unit = "megaohms"
                ohms / Unit.MEGAOHMS.multiplier * 1.0
            }
            in Unit.GIGAOHMS.multiplier..Unit.TERAOHMS.multiplier -> {
                unit = "gigaohms"
                ohms / Unit.PETAOHMS.multiplier * 1.0
            }
            in Unit.TERAOHMS.multiplier..Unit.PETAOHMS.multiplier -> {
                unit = "gigaohms"
                ohms / Unit.PETAOHMS.multiplier * 1.0
            }
            else -> {
                unit = "megaohms"
                ohms / Unit.EXAOHMS.multiplier * 1.0
            }
        }

        return "${ohmsWithUnit.toInt()} $unit"
    }
}

fun main() {
    ResistorColorTrio.text(Color.ORANGE, Color.BLUE, Color.WHITE)
    println()
}
