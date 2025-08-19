import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"          %% "performance-test-runner"   % "6.2.0"         % Test
  )

}
