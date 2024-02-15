import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';

const AllStudents = () => {
  const [students, setStudents] = useState([]);
  const [keyword, setKeyword] = useState('');
  const [searchResults, setSearchResults] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [itemsPerPage, setItemsPerPage] = useState(6); 
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

  useEffect(() => {
    fetchData();
  }, [currentPage]); // Refetch data when currentPage changes

  const handleSearch = async () => {
    try {
      const response = await axios.get(`http://localhost:8090/search?keyword=${keyword}`)
      setStudents(response.data.data);
      setCurrentPage(1); // Reset to first page after search
      console.log(response);
    } catch (error) {
      alert("No Student found with the given name")
      console.log("No Student Found ", error);
    }
  }

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

  const totalPages = Math.ceil(students.length / itemsPerPage);

  const startIndex = (currentPage - 1) * itemsPerPage;
  const endIndex = startIndex + itemsPerPage;
  const currentStudents = students.slice(startIndex, endIndex);

  return (
    <div className="container mt-5 p-2 rounded-3">
        <h1 className="m-3 text-center">All Students Details</h1>
      <div className="d-flex justify-content-between align-items-center mb-4">
        <h3>
          <Link to="/addStudent" className="btn btn-success">
            Add Student
          </Link>
        </h3>
        <div className="">
          <input type="text" className="rounded " value={keyword} onChange={e => setKeyword(e.target.value)} />
          <button className="btn btn-primary" onClick={handleSearch}>Search</button>
        </div>
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
          {currentStudents.map((s) => (
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

      {/* Pagination */}
      <div className="text-center">
        <button
          className="btn btn-primary"
          onClick={() => setCurrentPage(currentPage - 1)}
          disabled={currentPage === 1}
        >
          Prev
        </button>
        {Array.from({ length: totalPages }, (_, index) => (
          <button className="btn"
            key={index}
            onClick={() => setCurrentPage(index + 1)}
            disabled={currentPage === index + 1}
          >
            {index + 1}
          </button>
        ))}
        <button className="btn btn-primary"
          onClick={() => setCurrentPage(currentPage + 1)}
          disabled={currentPage === totalPages}
        >
          Next
        </button>
      </div>
    </div>
  );
};

export default AllStudents;
