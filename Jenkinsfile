// pipeline {
//   agent any
//   environment {
//     DOCKERHUB_CREDENTIALS = credentials ('dockerhub')
//     }
//     stages {
//       stage ('Build') {
//         steps {
//           sh 'mvn clean package'
//         }
//       }
//       stage( 'Build Docker image'){
//         steps {
//           sh 'docker buildx build --platform linux/amd64 -t students .'
//         }
//       }
//       stage('Login to Docker Hub') {
//         steps {
//           withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials-id', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB _PASSMORD' )]) {
//             sh "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"
//           }
//         }
//       }
//       stage('Pushing Docker image') {
//         steps {
//           sh 'docker push nreddyre/students'
//         }
//       }
//       stage('Deployment on k8') {
//         steps {
//           sh 'kubectl rollout restart deployment/deploy1'
//         }
//       }
//     }
// }

pipeline{
    agent any
    environment {
		DOCKERHUB_CREDENTIALS=credentials('dockerhub')
	}
  stages{
    stage('Build') {
      steps {
	// sh 'rm -rf *.var'
 //        sh 'jar -cvf swe645-hw2.war -C "webapp" .'     
 //        sh 'docker build -t rithvikathota/swe645-hw2:latest .'
        sh 'echo ok'
      }
    }
    stage('Login') {
      steps {
        // sh 'echo $DOCKERHUB_CREDENTIALS_PSW |docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
        sh 'echo ok'
       }
    }
    stage("Push image to docker hub"){
      steps {
        // sh 'docker push rithvikathota/swe645-hw2:latest'
        sh 'echo ok'
      }
    }
        stage("deploying on k8")
	{
		steps{
			// sh 'kubectl set image deployment/deploy1 container-0=rithvikathota/swe645-hw2:latest -n default'
			// sh 'kubectl rollout restart deploy deploy1 -n default'
			sh 'echo ok'
		}
	} 
  }
 
  post {
	  always {
			// sh 'docker logout'
      sh 'echo ok'
		}
	}    
}
