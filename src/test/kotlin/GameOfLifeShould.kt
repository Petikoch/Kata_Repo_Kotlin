import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameOfLifeShould {

    @Test
    fun `live cell dies with 0 live neighbor cells`() {
        val situation = """
            ---
            -o-
            ---
        """.trimIndent()

        val nextGeneration = Board.createFromString(situation).nextGeneration()

        assertEquals("""
            ---
            ---
            ---
        """.trimIndent(),
                nextGeneration.toString()
        )
    }

    @Test
    fun `live cell dies with 1 live neighbor cells`() {
        val situation = """
            ----
            -oo-
            ----
        """.trimIndent()

        val nextGeneration = Board.createFromString(situation).nextGeneration()

        assertEquals("""
            ----
            ----
            ----
        """.trimIndent(),
                nextGeneration.toString()
        )
    }

    @Test
    fun `live cell lives on with 2 live neighbor cells`() {
        val situation = """
            --o-
            -oo-
            ----
        """.trimIndent()

        val nextGeneration = Board.createFromString(situation).nextGeneration()

        assertEquals("""
            -oo-
            -oo-
            ----
        """.trimIndent(),
                nextGeneration.toString()
        )
    }

    @Test
    fun `live cell lives on with 3 live neighbor cells`() {
        val situation = """
            -----
            -ooo-
            --o--
        """.trimIndent()

        val nextGeneration = Board.createFromString(situation).nextGeneration()

        assertEquals("""
            --o--
            -ooo-
            -ooo-
        """.trimIndent(),
                nextGeneration.toString()
        )
    }

    @Test
    fun `live cell dies with 4 live neighbor cells`() {
        val situation = """
            --o--
            -ooo-
            --o--
        """.trimIndent()

        val nextGeneration = Board.createFromString(situation).nextGeneration()

        assertEquals("""
            -ooo-
            -o-o-
            -ooo-
        """.trimIndent(),
                nextGeneration.toString()
        )
    }

    @Test
    fun `dead cell with exactly 3 live neighbor cells becomes alive`() {
        val situation = """
            --o--
            -o-o-
            -----
        """.trimIndent()

        val nextGeneration = Board.createFromString(situation).nextGeneration()

        assertEquals("""
            --o--
            --o--
            -----
        """.trimIndent(),
                nextGeneration.toString()
        )
    }

}