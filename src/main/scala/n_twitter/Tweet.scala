package n_twitter

case class Author(name: String)
case class Hashtag(name: String) {
  require(name.startsWith("#"), "Hashtag ust start with #")
  override def toString: String = name
}

case class Tweet(author: Author, body: String) {
    def hashtags: Set[Hashtag] = {
      body.split(" ").collect{case t if t.startsWith("#") => Hashtag(t)}.toSet
    }
}
