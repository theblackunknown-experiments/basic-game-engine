package org.blackpanther.game
package ui

import scala.swing._
import java.awt.{Image, Graphics, Dimension, Toolkit}
import javax.swing.JPanel

/**
 * @author MACHIZAUD Andréa
 * @version 8/26/11
 */
object GamePanel extends JPanel {

  //TODO : Explore Fullscreen API
  val fullScreenEnabled = false;

  setPreferredSize(
    if( fullScreenEnabled ) {
      Toolkit.getDefaultToolkit.getScreenSize
    } else {
      new java.awt.Dimension(400,400)
    }
  )

  println("Panel preferred size : " + getPreferredSize)

  var scene : Image = _

  override def paintComponent(g : Graphics) {
    super.paintComponent(g)

    require(scene != null, "Scene is not cached")

    g.drawImage(
      scene,
      0,0,
      scene.getWidth(null),
      scene.getHeight(null),
      null
    )
  }


}
