@ignore
# This is a reusuable feature of gitLab create issue operation
Feature: I want to generate reusuable Createissue operation in Gitlab

    #This scenario will be used create the issues in gitlab
    #Mandatory Input: title
    #optional Input: assignee_id, assignee_ids, confidential, created_at, description, discussion_locked, due_date, labels, add_labels, remove_labels, milestone_id, state_event, title, issue_type, weight, epic_id, epic_iid
    #Sample Input: {'title':'<Your issue title goes here>'}
    #Authentication: Oauth or Private-Token
    #This scenario verify the status code and return the response back
    Scenario: create issues
        Given url baseUrl + 'api/v4/projects/'+projectId+'/issues/'
        And request createRequest[0]
        When method post
        Then status 201