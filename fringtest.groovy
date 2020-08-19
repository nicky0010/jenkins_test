properties([
	parameters([
		string(name: 'frEdfBranch', defaultValue: 'support/v1.0', description: 'github target branch'),
		string(name: 'frEdfUtilsBranch', defaultValue: 'support/v1.0', description: 'github target branch'),
		[
			$class      : 'ChoiceParameter',
			choiceType  : 'PT_CHECKBOX',
			description : 'target deploy component',
			filterLength: 1,
			filterable  : true,
			name        : 'components',
			script      : [
				$class        : 'GroovyScript',
				fallbackScript: [
					classpath: [],
					sandbox  : false,
					script   : 'return ["ERROR"]'
				],
				script        : [
					classpath: [],
					sandbox  : false,
					script   : 'return[\'fr-edf\',\'fr-edf-utils\']'
				]
			]
		],
		string(name: 'JENKINS_AGENT', defaultValue: 'master', description: 'jenkins job agent'),
	])
])

pipeline {
	agent any
	stages {
		stage('Publish') {
			steps {
				deleteDir()
				script {
					commonProperties = readYaml file: "${pwd()}@script/jenkinsfiles/nicky-artifact/envs/common.yml"
					props = commonProperties.props
					mavenSetting = "${pwd()}@script/${props.mavenSettingXmlPath}"
				}
			}
		}
	}
}
