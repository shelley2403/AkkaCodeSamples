package n_twitter

import com.typesafe.config.ConfigFactory

object TwitterConfiguration {
  val config = ConfigFactory.load.getConfig("Twitter")
  val accessTokenSecret: String = config.getString("apiKey")
  val apiKey= config.getString("apiSecret")
  val apiSecret = config.getString("accessToken")
  val accessToken = config.getString("accessTokenSecret")

}
