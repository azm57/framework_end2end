pipeline {
  agent any
  stages {
    stage("build")  {
      steps{
        echo 'building application...'
        script{
          mvn compile}
      }
    }
    stage("test")  {
      steps{
        echo 'testing application...'
        script{
          mvn test}
      }
     }
     stage("deploy")  {
      steps{
        echo 'deploying application...'
        script{
        mvn install
        }
      }
     }
  }
}
