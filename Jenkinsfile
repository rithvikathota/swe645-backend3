// pipeline {
//   agent {
//     node {
//       label 'SWE645-HW3'
//     }
//   }
//   stages {
//     stage('Checkout') {
//       steps {
//         checkout scm
//       }
//     }
//     stage('Build') {
//       steps {
//         sh 'mvn clean install'
//       }
//       post {
//         success {
//           archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
//         }
//       }
//     }
//     stage('Docker Build and Push') {
//       steps {
//         withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
//           sh "echo ${PASSWORD} | sudo docker login -u ${USERNAME} --password-stdin"
//           sh "sudo docker build -t 'nreddyre/students' ."
//           sh "sudo docker push nreddyre/students"
//         }
//       }
//     }
//     stage('Deploy to Kubernetes') {
//       steps {
//         sh "kubectl rollout restart deploy deploy1"
//       }
//     }
//   }
// }

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
