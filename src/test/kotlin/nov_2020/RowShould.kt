package nov_2020

import Cell
import Row
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RowShould {

    @Test
    fun `create row from string`() {
        assertEquals(
            Row(),
            Row.createFromString("")
        )
        assertEquals(
            Row(cells = listOf(Cell(alive = false), Cell(alive = false), Cell(alive = false))),
            Row.createFromString("---")
        )
        assertEquals(
            Row(cells = listOf(Cell(alive = true), Cell(alive = true), Cell(alive = true))),
            Row.createFromString("ooo")
        )
    }

}