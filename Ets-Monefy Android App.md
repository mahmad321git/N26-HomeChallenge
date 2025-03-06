# Monefy Testing Deliverables

This document outlines the exploratory testing session, mobile app test automation, and RESTful API test automation solutions for the Monefy application. It details the testing charters, findings, prioritization, risks, as well as the automated testing frameworks and their setup.

---

## 1. Exploratory Testing Session of the Monefy App (Android)

### Overview
For this session, I chose the Android platform. The goal was to assess key functionalities of the Monefy app, including transaction management, settings customization, reporting, and backup/restore features.

### Exploratory Testing Charters

1. **Initial App Launch & Navigation**
   - **Objective:** Verify the installation, launch, and navigation of the app.
   - **Focus Areas:** Home screen load time, menu accessibility, intuitive navigation, UI element alignment.
   
2. **Transaction Entry (Income/Expense)**
   - **Objective:** Validate that users can add, edit, and delete both income and expense transactions.
   - **Focus Areas:** Correct amount entry, category selection, date/time stamps, updates to totals.

3. **Settings and Preferences**
   - **Objective:** Ensure that personalization options work as expected.
   - **Focus Areas:** Changing currency, theme, language; persistence of settings after app restart.

4. **Reports & Analytics**
   - **Objective:** Test the generation of financial reports and charts.
   - **Focus Areas:** Accuracy of data summaries, responsiveness of charts, correct filtering by date range.

5. **Backup & Restore**
   - **Objective:** Verify that backup and restoration features protect user data.
   - **Focus Areas:** Successful backup creation, clarity of the restore process, handling of duplicate data.

### Findings from Exploratory Testing

- **Initial App Launch & Navigation**
  - The home screen loaded quickly. However, some icons lacked clear labels, leading to minor navigation confusion.
  - UI alignment issues were noted on devices with smaller screen sizes.

- **Transaction Entry**
  - **Positive:** Adding new income/expense transactions was generally smooth.
  - **Issues:** 
    - **Bug:** Editing an expense transaction did not update the overall totals immediately.
    - **Bug:** The deletion of a transaction sometimes required multiple attempts to register.
  
- **Settings and Preferences**
  - Currency changes were applied but not uniformly reflected in all UI areas.
  - Theme changes worked, though the update had a slight delay on some devices.

- **Reports & Analytics**
  - Generated reports accurately summarized data; however, chart loading was occasionally slow.
  
- **Backup & Restore**
  - Backup creation was successful; however, the restoration process lacked clear guidance and resulted in some duplicated data entries.

### Prioritisation of Charters

1. **Transaction Entry:**  
   - **Priority:** High  
   - **Reason:** Core functionality affecting data accuracy; bugs here can mislead financial tracking.
   
2. **Backup & Restore:**  
   - **Priority:** High  
   - **Reason:** Risks data loss or duplication, directly impacting user trust and data integrity.
   
3. **Settings and Preferences:**  
   - **Priority:** Medium  
   - **Reason:** While important for personalization, issues here have less impact on the core financial operations.
   
4. **Reports & Analytics:**  
   - **Priority:** Medium  
   - **Reason:** Performance delays in report generation affect usability but do not compromise data accuracy.
   
5. **Initial App Launch & Navigation:**  
   - **Priority:** Low  
   - **Reason:** UI misalignments and labeling issues are less critical compared to transactional errors.

### Risks & Mitigation Strategies

- **Data Integrity Risk:**  
  - *Risk:* Inaccurate transaction updates/deletions could lead to misleading financial data.  
  - *Mitigation:* Enhance automated tests for CRUD operations and implement data validation routines.

- **User Experience Risk:**  
  - *Risk:* Poor UI alignment and delayed updates may frustrate users.  
  - *Mitigation:* Conduct thorough UI/UX testing on multiple devices and refine responsiveness.

- **Data Loss Risk:**  
  - *Risk:* Inadequate backup/restore processes might result in data loss or duplication.  
  - *Mitigation:* Improve user guidance during backup/restore and perform integration tests for data consistency.

- **Performance Risk:**  
  - *Risk:* Slow report generation could hinder the user experience.  
  - *Mitigation:* Optimize backend processing and consider caching strategies for frequently generated reports.

---