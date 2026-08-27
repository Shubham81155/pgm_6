# Implementation Plan - Comprehensive Registration Form

Transform the current application into a complete, feature-rich Registration Form. This will build upon the aesthetic card-based design and include standard registration features like validation and specific input types.

## Proposed Changes

### UI Layout
#### [MODIFY] [activity_main.xml](file:///C:/Users/aradh/AndroidStudioProjects/Exp6/app/src/main/res/layout/activity_main.xml)
- **Header**: Change "User Profile" to "Create Account".
- **Account Details Card**:
    - `EditText` (Name): Keep existing.
    - `EditText` (Email): Add with `emailAddress` input type.
    - `EditText` (Password): Add with `textPassword` input type and end-icon toggle.
- **Personal Info Card**:
    - `RadioGroup` (Gender): Update options to "Male", "Female", "Other".
    - `Button`: Add a "Select Date of Birth" button (will use `DatePickerDialog`).
- **Preferences Card**:
    - `CheckBox`: "Accept Terms & Conditions".
    - `ToggleButton`: "Subscribe to Newsletter".
- **Actions**:
    - `Button`: "Register" (Submit).
    - `ImageButton`: "Upload Profile Picture" (Keep existing profile section).

### Activity Logic
#### [MODIFY] [MainActivity.kt](file:///C:/Users/aradh/AndroidStudioProjects/Exp6/app/src/main/java/com/example/exp6/MainActivity.kt)
- **Initialization**: Bind new views (Email, Password, Date Button).
- **Date Picker**: Implement `DatePickerDialog` to let users select their birth date.
- **Form Validation**:
    - Check if Name, Email, and Password are not empty.
    - Verify Email format using `Patterns.EMAIL_ADDRESS`.
    - Ensure "Terms & Conditions" are checked.
- **Registration Action**:
    - Show a `Toast` or update the `Live Summary` with "Registration Successful" only if validation passes.
    - Clear form or show success state.

## Verification Plan

### Manual Verification
- **Empty Form**: Click "Register" without filling anything; verify that errors or a "Validation Failed" message appears.
- **Email Validation**: Enter an invalid email (e.g., "test@com") and verify the error.
- **Terms Check**: Try to register without checking the Terms; verify the requirement.
- **Date Selection**: Click the Date button, select a date, and verify it displays on the button or in the summary.
- **Success Case**: Fill all fields correctly and verify the "Registration Successful" message.
