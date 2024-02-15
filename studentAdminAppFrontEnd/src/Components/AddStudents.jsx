import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const AddStudents = () => {
  let [firstName, setFirstName] = useState("");
  let [lastName, setLastName] = useState("");
  let [gender, setGender] = useState("");
  let [phoneNumber, setPhoneNumber] = useState("");
  let navigate = useNavigate()
  let AddStudent = (e) => {
    e.preventDefault();
    let student = { firstName, lastName, gender, phoneNumber };
    axios
      .post("http://localhost:8090/students", student)
      .then((response) => {
        alert(
          "Student Data Saved Successfully!! with id " +
            response.data.data.studentId
        );
          navigate("/")
        console.log(response.data.data.studentId);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  // function getStudent() {
  //   axios
  //     .get(`http://localhost:8090/students/1`)
  //     .then((response) => {
  //       console.log(response.data);
  //     })
  //     .catch((error) => {
  //       console.log("error" + error);
  //     });
  // }
  // getStudent();
  return (
    <div className="container mt-5">
      <h1 className="text-center">Add Students</h1>
      <form onSubmit={AddStudent} className="container shadow w-50">
        <div className="mb-3">
          <label htmlFor="firstName" className="form-label">
            First Name
          </label>
          <input
            type="text"
            className="form-control"
            id="firstName"
            placeholder="First Name"
            value={firstName}
            onChange={(e) => {
              setFirstName(e.target.value);
            }}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="lastName" className="form-label">
            Last Name
          </label>
          <input
            type="text"
            className="form-control"
            id="lastName"
            placeholder="Last Name"
            value={lastName}
            onChange={(e) => {
              setLastName(e.target.value);
            }}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="gender" className="form-label">
            Gender
          </label>
          <input
            type="text"
            className="form-control"
            id="gender"
            placeholder="Male/Female"
            value={gender}
            onChange={(e) => {
              setGender(e.target.value);
            }}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="phoneNumber" className="form-label">
            Phone Number
          </label>
          <input
            type="text"
            className="form-control"
            id="phoneNumber"
            placeholder="Phone Number"
            value={phoneNumber}
            onChange={(e) => {
              setPhoneNumber(e.target.value);
            }}
            required
          />
        </div>
        <div className="container text-center">
          <button type="submit" className="btn btn-primary text-center">
            Add Student
          </button>
        </div>
      </form>
    </div>
  );
};

export default AddStudents;
