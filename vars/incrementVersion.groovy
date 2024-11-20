#!/user/bin/env groovy
def call(String appDir){
    dir(appDir) {
        sh "npm version minor"
        def packageJson = readJSON file: 'package.json'
        def version = packageJson.version
        env.IMAGE_NAME = "${version}-${env.BUILD_NUMBER}"
    }
}
