import cars.Car;
import cars.CarGenerator;
import cars.CarGeneratorService;
import message.EncodingMethod;
import message.Message;
import message.MessageEncoder;
import message.ShiftDirection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarGeneratorServiceTest{

    @InjectMocks
    CarGeneratorService carGeneratorService;

    @Test
    public void test(){
        ArguemntCaptor<String> plateCaptor = ArgumentCaptor.forClass(String.class);

        Car car = new Car();
        car.setColor("blue");
        car.setMake("BMW");
        when(carGenerator.generateCar(eq("BMW"), eq("blue")));

        Car returnedCar = carGeneratorService.generateCar("bmw", "blue");

        verify(carGenerator).savePlateToDB(plateCaptor.capture());
        verify(carGenerator).savePlateToDB(plateCaptor.getValue());

        assertEquals(plateCaptor.getValue().substring(0,3), "GDA");


    }
}
