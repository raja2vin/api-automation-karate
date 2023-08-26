@ignore
# This is a reusuable feature of gitLab delete issue operation
Feature: I want to generate reusuable delete issue operation in Gitlab

    #This scenario will be used delete the issues in gitlab
    #Mandatory Input: issue id (iid)
    #Authentication: Oauth or Private-Token
    #This scenario verify the status code and return the response back
    Scenario: delete issues
        * def issueId = deleteIssueId
        Given url baseUrl + 'api/v4/projects/'+projectId+'/issues/' + deleteIssueId
        When method DELETE
        Then status 204