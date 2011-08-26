package org.blackpanther.game
package engine
package strategy

import engine.GameEngine.GameState

/**
 * @author MACHIZAUD Andréa
 * @version 8/26/11
 */

sealed abstract class Strategy

abstract class UpdateStrategy extends Strategy {
  def update(state : GameState) : Unit
}
abstract class RenderStrategy extends Strategy {
  def render(state : GameState) : Unit
}
abstract class PainterStrategy extends Strategy {
  def repaint(state : GameState) : Unit
}
abstract class TimerStrategy extends Strategy {
  def sleep(state : GameState) : Unit
}

private[strategy] abstract class StrategyType

private [strategy] 
abstract class StrategyProvider[ProvidedStrategy <: Strategy, ProvidedType <: StrategyType] {

  def apply(request : ProvidedType) : ProvidedStrategy

}
