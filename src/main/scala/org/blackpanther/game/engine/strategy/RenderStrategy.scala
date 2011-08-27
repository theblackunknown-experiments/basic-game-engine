package org.blackpanther.game
package engine
package strategy

object RenderStrategyProvider extends StrategyProvider {

  import engine.GameEngine.GameState

  object Buffered extends RenderStrategy {

    import ui.GamePanel
    import java.awt.{Color, Graphics, Image}
    import java.awt.image.BufferedImage

    /*
    * TODO Explore Volatile Image
    * 
    * Because Volatile Image could be lost at any time, 
    * we ought use it for an efficient render, then get a snapshot of it as a BufferedImage
    * http://download.oracle.com/javase/6/docs/api/java/awt/image/VolatileImage.html
    */
    private val bufferImage = 
      new BufferedImage(
        GamePanel.getPreferredSize.width,
        GamePanel.getPreferredSize.height,
        BufferedImage.TYPE_INT_RGB
      )

    val width = GamePanel.getPreferredSize.width
    val height = GamePanel.getPreferredSize.height

    def apply(state : GameState) : Image = 
      render { (graphics :Graphics) =>

        graphics.setColor(Color.white)
        graphics.fillRect(0,0,width,height)

        graphics.setColor(Color.black)
        graphics.drawString(
          "Under construction",
          width / 3,
          height / 2
        )

        if(state.over) {
          gameOverMessage(graphics)
        }
      }

    def gameOverMessage(graphics : Graphics) {
      graphics.setColor(Color.red)
      graphics.drawString(
        "Game Over",
        width / 3,
        height / 8
      )
    }


    private def render(computation : (Graphics) => Unit) : Image = {
      val graphics = bufferImage.getGraphics

      computation(graphics)

      graphics.dispose()

      println("Game is rendered with a buffer")

      bufferImage
    }

  }

}
