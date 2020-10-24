package com.test;

import com.test.domain.DirectionEnum;
import com.test.domain.Position;
import com.test.domain.PositionBuilder;
import com.test.service.NavigationService;
import com.test.service.NavigationServiceImpl;
import com.test.util.NavigationUtil;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern ROBOT_POSITION_PATTERN = Pattern.compile("^(\\d+\\s\\d+\\s)[NEWS]$");
    private static final Pattern GRID_PATTERN = Pattern.compile("^\\d+\\s\\d$");
    private static final Pattern INSTRUCTION_PATTERN = Pattern.compile("^[LMR]+$");

    public static void main(String[] args) {
        // Get input from command line for various
        System.out.println("Welcome to Moonlanding!");
        Scanner scanner = new Scanner(System.in);

        // INPUT 1
        System.out.print("Enter the size of the grid: ");
        String gridSize = scanner.nextLine();
        NavigationUtil.validateInput(gridSize, GRID_PATTERN, "Incorrect Grid input");
        int maxX = NavigationUtil.getIntFromSpaceSeparatedStringAt(gridSize, 0);
        int maxY = NavigationUtil.getIntFromSpaceSeparatedStringAt(gridSize, 1);
        NavigationService navigationService = new NavigationServiceImpl(maxX, maxY);

        // INPUT 2
        System.out.print("Enter the initial position of robot1: ");
        String initialPosition = scanner.nextLine();
        NavigationUtil.validateInput(initialPosition, ROBOT_POSITION_PATTERN, "Invalid Robot position");
        Position p1 = new Position(
                NavigationUtil.getIntFromSpaceSeparatedStringAt(initialPosition, 0),
                NavigationUtil.getIntFromSpaceSeparatedStringAt(initialPosition, 1),
                DirectionEnum.valueOf(NavigationUtil.getValueFromSpaceSeparatedStringAt(initialPosition, 2))
        );

        // INPUT 3
        System.out.print("Enter the navigation instruction for robot1: ");
        String instruction1 = scanner.nextLine();
        NavigationUtil.validateInput(instruction1, INSTRUCTION_PATTERN, "Invalid instruction input");
        navigationService.processInstructions(p1, instruction1.toCharArray());

        // INPUT 4
        System.out.print("Enter the initial position of robot2: ");
        initialPosition = scanner.nextLine();
        NavigationUtil.validateInput(initialPosition, ROBOT_POSITION_PATTERN, "Invalid Robot position");
        Position p2 = new PositionBuilder()
                .withX(NavigationUtil.getIntFromSpaceSeparatedStringAt(initialPosition, 0))
                .withY(NavigationUtil.getIntFromSpaceSeparatedStringAt(initialPosition, 1))
                .withDirectionEnum(DirectionEnum.valueOf(NavigationUtil.getValueFromSpaceSeparatedStringAt(initialPosition, 2)))
                .build();

        // INPUT 5
        System.out.print("Enter the navigation instruction for robot2: ");
        String instruction2 = scanner.nextLine();
        NavigationUtil.validateInput(instruction2, INSTRUCTION_PATTERN, "Invalid instruction input");
        navigationService.processInstructions(p2, instruction2.toCharArray());

        // OUTPUT
        System.out.println(p1);
        System.out.println(p2);

    }


}
