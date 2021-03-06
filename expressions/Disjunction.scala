package expressions

import ui._
import values._

//Or ||
case class Disjunction(operands: List[Expression]) extends SpecialForm {
  def execute(env: Environment): Value = {
    var result = false
    var i = 0
    while (!result && i < operands.length) {
      val v = operands(i).execute(env)
      if (!v.isInstanceOf[Boole]) throw new TypeException("Need a type Boole")
      val b = v.asInstanceOf[Boole]
      result = b.value
      i += 1
    }
    new Boole(result)
  }
}