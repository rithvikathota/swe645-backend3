pipeline{
    agent any
    environment {
		DOCKERHUB_CREDENTIALS=credentials('Docker')
	}
  stages{
    stage('Build') {
      steps {
        sh 'mvn clean install'
      }
      post {
        success {
          archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
      }
    }
    stage('Login') {
      steps {
        sh 'echo $DOCKERHUB_CREDENTIALS_PSW |docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
       }
    }
    stage("Push image to docker hub"){
      steps {
        sh "sudo docker push nreddyre/students:latest"
      }
    }
        stage("deploying on k8")
	{
		steps{
			sh 'kubectl set image deployment/deploy1 container-0=nreddyre/students:latest -n default'
			sh 'kubectl rollout restart deploy deploy1 -n default'
		}
	} 
  }
 
  post {
	  always {
			sh 'docker logout'
		}
	}    
}
