#!/user/bin/env groovy
def call(String appDir) {
    dir(appDir) {
        sh "npm install"
        sh "npm run test"
    }
}