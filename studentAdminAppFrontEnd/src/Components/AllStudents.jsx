import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

const AllStudents = () => {
  const [students, setStudents] = useState([]);
  const navigate = useNavigate();

  const handleUpdate = (studentId) => {
    navigate(`/update/${studentId}`);
  };

  const fetchData = async () => {
    try {
      const response = await axios.get("http://localhost:8090/students");
      setStudents(response.data.data);
    } catch (error) {
      console.log("Error fetching students:", error);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  const handleDelete = (id) => {
    const studentId = parseInt(id, 10);

    axios
      .delete(`http://localhost:8090/students/${studentId}`)
      .then(() => {
        alert("Student with Id " + studentId + " deleted successfully");
        fetchData();
      })
      .catch((error) => {
        console.log("Error deleting student:", error);
      });
  };

  return (
    <div className="container mt-5">
      <div className="d-flex justify-content-between align-items-center mb-4">
        <h1 className="m-0">All Students Details</h1>
        <h3>
          <Link to="/addStudent" className="btn btn-success">
            Add Student
          </Link>
        </h3>
      </div>
      <table className="table table-bordered bg-primary">
        <thead>
          <tr>
            <th>Student Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>Phone Number</th>
            <th>Update</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          {students.map((s) => (
            <tr key={s.studentId}>
              <td>{s.studentId}</td>
              <td>{s.firstName}</td>
              <td>{s.lastName}</td>
              <td>{s.gender}</td>
              <td>{s.phoneNumber}</td>
              <td>
                <button
                  className="btn btn-primary"
                  onClick={() => handleUpdate(s.studentId)}
                >
                  Update
                </button>
              </td>
              <td>
                <button
                  className="btn btn-danger"
                  onClick={() => handleDelete(s.studentId)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default AllStudents;
