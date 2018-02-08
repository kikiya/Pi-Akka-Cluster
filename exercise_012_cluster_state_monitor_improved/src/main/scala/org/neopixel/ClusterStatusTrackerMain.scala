/**
  * Copyright © 2018 Lightbend, Inc
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  *
  * NO COMMERCIAL SUPPORT OR ANY OTHER FORM OF SUPPORT IS OFFERED ON
  * THIS SOFTWARE BY LIGHTBEND, Inc.
  *
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */

package org.neopixel

import java.net.InetSocketAddress

import akka.actor.ActorSystem
import neopixel.{rpi_ws281xConstants => wsC}

object ClusterStatusTrackerMain {
  def main(args: Array[String]): Unit = {
    System.loadLibrary("rpi_ws281x")

    val clusterNodeAddress = new InetSocketAddress("localhost", 2500)
    val ledStatusIndicatorAddress = new InetSocketAddress("localhost", 2501)

    val system = ActorSystem("pi-cluster-system")

    val clusterStatusTracker =
      system.actorOf(ClusterStatusTracker.props(clusterNodeAddress, ledStatusIndicatorAddress))
  }
}