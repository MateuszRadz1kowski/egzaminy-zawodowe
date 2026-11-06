import logo from "./logo.svg";
import "./App.css";
import { useEffect, useState } from "react";
import { Button, Card, Col, Form, Image, Row } from "react-bootstrap";

function App() {
  const [data, setData] = useState([
    { id: 0, alt: "Mak", filename: "obraz1.jpg", category: 1, downloads: 35 },
    {
      id: 1,
      alt: "Bukiet",
      filename: "obraz2.jpg",
      category: 1,
      downloads: 43,
    },
    {
      id: 2,
      alt: "Dalmatyńczyk",
      filename: "obraz3.jpg",
      category: 2,
      downloads: 2,
    },
    {
      id: 3,
      alt: "Świnka morska",
      filename: "obraz4.jpg",
      category: 2,
      downloads: 53,
    },
    {
      id: 4,
      alt: "Rotwailer",
      filename: "obraz5.jpg",
      category: 2,
      downloads: 43,
    },
    { id: 5, alt: "Audi", filename: "obraz6.jpg", category: 3, downloads: 11 },
    { id: 6, alt: "kotki", filename: "obraz7.jpg", category: 2, downloads: 22 },
    { id: 7, alt: "Róża", filename: "obraz8.jpg", category: 1, downloads: 33 },
    {
      id: 8,
      alt: "Świnka morska",
      filename: "obraz9.jpg",
      category: 2,
      downloads: 123,
    },
    {
      id: 9,
      alt: "Foksterier",
      filename: "obraz10.jpg",
      category: 2,
      downloads: 22,
    },
    {
      id: 10,
      alt: "Szczeniak",
      filename: "obraz11.jpg",
      category: 2,
      downloads: 12,
    },
    {
      id: 11,
      alt: "Garbus",
      filename: "obraz12.jpg",
      category: 3,
      downloads: 321,
    },
  ]);

  const [isFlowersSwitched, setIsFlowersSwitched] = useState(true);
  const [isAnimalsSwitched, setIsAnimalsSwitched] = useState(true);
  const [isCarsSwitched, setIsCarsSwitched] = useState(true);

  const handleImageDownload = (targetObject) => {
    setData((prevData) =>
      prevData.map((item) =>
        item.id === targetObject.id
          ? { ...item, downloads: item.downloads + 1 }
          : item,
      ),
    );
  };

  useEffect(() => {
    console.log(data);
  }, [data]);

  return (
    <div className="container mt-4">
      <h1>Kategorie zdjęć</h1>

      <Form className="mb-4">
        <Form.Switch
          label="Kwiaty"
          onChange={() => setIsFlowersSwitched(!isFlowersSwitched)}
          checked={isFlowersSwitched}
        />
        <Form.Switch
          label="Zwierzęta"
          onChange={() => setIsAnimalsSwitched(!isAnimalsSwitched)}
          checked={isAnimalsSwitched}
        />
        <Form.Switch
          label="Samochody"
          onChange={() => setIsCarsSwitched(!isCarsSwitched)}
          checked={isCarsSwitched}
        />
      </Form>

      <Row>
        {data.map((object) => {
          if (!isFlowersSwitched && object.category === 1) return null;
          if (!isAnimalsSwitched && object.category === 2) return null;
          if (!isCarsSwitched && object.category === 3) return null;

          return (
            <Col key={object.id} xs={12} sm={6} md={4} lg={3} className="mb-3">
              <Card className="h-100 p-2 text-center">
                <Image
                  src={`/assets/${object.filename}`}
                  alt={object.alt}
                  className="img-fluid rounded"
                  style={{ margin: "5px", borderRadius: "10px" }}
                />
                <Card.Body className="d-flex flex-column justify-content-between">
                  <h4>Pobrań: {object.downloads}</h4>
                  <Button
                    onClick={() => handleImageDownload(object)}
                    variant="success"
                  >
                    Pobierz
                  </Button>
                </Card.Body>
              </Card>
            </Col>
          );
        })}
      </Row>
    </div>
  );
}

export default App;
