pipeline {
    agent any
    
    triggers {
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', 
                url: 'https://github.com/Cryxile/load_testing.git'
            }
        }
        
        stage('Run JMeter') {
            steps {
                script {
                    sh '''
                        /opt/jmeter/bin/jmeter -n \
                          -t ${WORKSPACE}/load-testing/load_test.jmx
                    '''
                }
            }
        }
    }
}