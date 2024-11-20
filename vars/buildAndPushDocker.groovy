#!/user/bin/env groovy

import com.example.Docker

def call(String credentialsId, String imageName, String dockerfilePath, String contextDir) {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh "docker build -t ${imageName} -f ${dockerfilePath} ${contextDir}"
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push ${imageName}"
    }
}